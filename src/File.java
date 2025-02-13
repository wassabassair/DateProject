public class File {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public File(File other) {
        this.name = other.name;
        this.size = other.size;
    }

    public boolean isSameFile(File other) {
        return (this.name.equals(other.name) && this.size == other.size);
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String toString() {
        return name + " " + size;
    }
}