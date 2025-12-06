import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class TreeNode<T> {
	private T value;
	private List<TreeNode<T>> children;

	public TreeNode(T value) {
		this.value = value;
		this.children = new ArrayList<>();
	}

	public T getValue() {
		return value;
	}

	public void addChild(TreeNode<T> child) {
		this.children.add(child);
	}

	public List<TreeNode<T>> getChildren() {
		return Collections.unmodifiableList(children);
	}

	public List<T> traverseAndCollect() {
		List<T> collectedValues = new ArrayList<>();
		
		recursiveHelp(this , collectedValues);
		return collectedValues;
	}

	public void recursiveHelp(TreeNode<T> currentNode , List<T> list)
	{
		list.add(currentNode.getValue());

		for(TreeNode<T> children : currentNode.children)
		{
			recursiveHelp(children, list);
		}

	}
}