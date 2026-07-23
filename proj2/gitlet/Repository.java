package gitlet;

import java.io.File;
import java.io.IOException;

import static gitlet.Utils.*;

// TODO: any imports you need here

/**
 * Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /**
     * The current working directory.
     */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /**
     * The .gitlet directory.
     */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    public static final File OBJECTS_DIR = join(GITLET_DIR, "objects");
    public static final File REFS_DIR = join(GITLET_DIR, "refs");
    public static final File BRANCH_DIR = join(REFS_DIR, "head");
    public static final File TAG_DIR = join(REFS_DIR, "tag");
    public static final File REMOTES_DIR = join(REFS_DIR, "remotes");
    public static final File HEAD_FILE = join(GITLET_DIR, "HEAD");
    public static final File INDEX_FILE = join(GITLET_DIR, "index");

    /* TODO: fill in the rest of this class. */

    public static void init() {
        // 如果当前目录已经初始化，则直接退出，并打印消息
        if (GITLET_DIR.exists()) {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(-1);
        }
        // 构建.gitlet目录
        GITLET_DIR.mkdir();
        OBJECTS_DIR.mkdir();
        REFS_DIR.mkdir();
        BRANCH_DIR.mkdir();
        TAG_DIR.mkdir();
        REMOTES_DIR.mkdir();
        try {
            // 创建master分支
            Utils.writeContents(HEAD_FILE, "refs/head/master");
            // 创建 暂存区
            INDEX_FILE.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
