package gitlet;

public abstract class GitObject {
    private int size;
    private String sha;

    public GitObject(int size, String sha) {
        this.size = size;
        this.sha = sha;
    }

    public abstract String getType();
}
