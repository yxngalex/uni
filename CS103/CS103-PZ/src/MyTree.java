import java.util.List;

public interface MyTree<T> {

    public void addChild(MyTreeNode<T> child);

    public void addChildren(List<MyTreeNode<T>> children);

}
