package cn.zhu;

public interface UF {
    void connect(int p, int q); // 在p和q直接添加一条连接

    boolean isConnected(int p, int q); // 判断p和q直接是否连接

    int find(int p); // p所在的连通分量标识符

    int count(); // 连通分量数量
}
