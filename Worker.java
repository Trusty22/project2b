// This could be similar to the ClientHandler defined above
class Worker implements Runnable {
    private Socket clientSocket;

    public Worker(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // Implement the handling logic here
    }
}
