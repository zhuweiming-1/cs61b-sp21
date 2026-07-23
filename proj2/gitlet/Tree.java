package gitlet;

import java.util.List;

public class Tree extends GitObject {
    private List<TreeEntry> entries;

    @Override
    public String getType() {
        return "tree";
    }

    private class TreeEntry {
        private String type;
        private String sha;
        private String name;
        private String permission;
    }
}
