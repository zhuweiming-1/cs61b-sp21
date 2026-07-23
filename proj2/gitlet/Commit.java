package gitlet;

// TODO: any imports you need here

import java.sql.Timestamp;
import java.util.Date; // TODO: You'll likely use this in this class

/**
 * Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author TODO
 */
public class Commit extends GitObject {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /**
     * The message of this Commit.
     */
    private String message;
    /**
     * 提交时间
     */
    private Timestamp timestamp;
    /**
     * 指向的tree对象
     */
    private Tree tree;
    /**
     * 父提交
     */
    private Commit parent1;
    /**
     * 父提交2，当该提交是通过合并产生时才会有第二个父提交
     */
    private Commit parent2;

    @Override
    public String getType() {
        return "commit";
    }

    public Commit(int size, String sha, String message, Timestamp timestamp, Tree tree, Commit parent1, Commit parent2) {
        super(size, sha);
        this.message = message;
        this.timestamp = timestamp;
        this.tree = tree;
        this.parent1 = parent1;
        this.parent2 = parent2;
    }



    /* TODO: fill in the rest of this class. */

    private static Commit ZERO_COMMIT = new Commit(0, "", "initial commit", new Timestamp(0), null, null, null);


    public static Commit getZeroCommit() {
        return ZERO_COMMIT;
    }
}
