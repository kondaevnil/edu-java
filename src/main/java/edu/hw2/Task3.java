package edu.hw2;
import java.util.Random;

public class Task3 {
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public class StableConnection implements Connection {

        @Override
        public void execute(String command) { }

        @Override
        public void close() throws Exception { }
    }

    public class FaultyConnection implements Connection {
        private final Random random = new Random();
        private boolean isSuccess() {
            return  random.nextBoolean();
        }

        @Override
        public void execute(String command) {
            if (!isSuccess()) {
                throw new ConnectionException();
            }
        }

        @Override
        public void close() throws Exception { }
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public class DefaultConnectionManager implements ConnectionManager {
        private final Random random = new Random();
        private boolean isStableConnection() {
            return random.nextBoolean();
        }

        @Override
        public Connection getConnection() {
            if (isStableConnection()) {
                return new StableConnection();
            }

            return new FaultyConnection();
        }
    }

    public class FaultyConnectionManager implements ConnectionManager {

        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public class ConnectionException extends RuntimeException {

        ConnectionException() {
            super();
        }

        ConnectionException(Throwable cause) {
            super(cause);
        }
    }

    public final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) {
            var connection = manager.getConnection();
            ConnectionException connectionException = null;

            for (int i = 0; i < maxAttempts; i++) {
                try {
                    connection.execute(command);
                    return;
                } catch (ConnectionException exception) {
                    connectionException = exception;
                }
            }

            throw new ConnectionException(connectionException);
        }
    }
}
