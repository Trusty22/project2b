class Worker implements Runnable {
    private Socket clientSocket;

    public Worker(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {}
}
