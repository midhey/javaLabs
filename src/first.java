public class first {
    public void lab1() {
        Monitor Asus = new Monitor(1920, 1080, "Asus", "Alexey");
        Asus.setOwner("Andrey");
        System.out.println(Asus.getOwner());
        Asus.printResolution();
    }
}

class Monitor {
    private int resolutionWidth;
    private int resolutionHeight;
    private String vendor;
    private String owner;
    public Monitor(int width, int height, String vendor, String owner) {
        this.resolutionWidth = width;
        this.resolutionHeight = height;
        this.vendor = vendor;
        this.owner = owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void printResolution() {
        System.out.println(resolutionWidth+"x"+resolutionHeight);
    }
}
