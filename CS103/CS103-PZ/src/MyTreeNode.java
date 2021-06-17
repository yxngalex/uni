import java.util.ArrayList;
import java.util.List;

public class MyTreeNode<T> implements MyTree<T> {

    private T data = null;
    private List<MyTreeNode<T>> children = new ArrayList<>();
    private MyTreeNode<T> parent = null;

    public MyTreeNode() {
    }

    public MyTreeNode(T data) {
        this.data = data;
    }

    @Override
    public void addChild(MyTreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    @Override
    public void addChildren(List<MyTreeNode<T>> children) {
        for (MyTreeNode<T> t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<MyTreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }
}