class Worker implements Runnable {
    /*
    * This class (Worker) just acts basiclly as a contructor for the server, run, and clientserver.
    * It gets properly used/overided and implented in MTP
    */
    private Socket soc;

    public Worker(Socket socket) {
        this.soc = socket;
    }

    @Override
    public void run() {}
}
