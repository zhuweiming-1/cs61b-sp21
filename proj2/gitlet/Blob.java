package gitlet;

public class Blob extends GitObject {
    private byte[] content;

    @Override
    public String getType() {
        return "";
    }
}
