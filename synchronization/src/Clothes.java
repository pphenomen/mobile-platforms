class Clothes {
    private final int clientId;
    private final String item;

    public Clothes(int clientId, String item) {
        this.clientId = clientId;
        this.item = item;
    }

    public int getClientId() {
        return clientId;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Клиент #" + clientId + " — " + item;
    }
}