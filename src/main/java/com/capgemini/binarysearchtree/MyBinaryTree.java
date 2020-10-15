package com.capgemini.binarysearchtree;

public class MyBinaryTree<K extends Comparable<K>> {
	private MyBinaryNode<K> root;
	public void add(K key) {
		this.root = this.addRecursively(root, key);
	}

	private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key){
		if(current == null)
			return new MyBinaryNode<>(key);
		int compareResult = key.compareTo(current.key);
		if(compareResult == 0)
			return current;
		if(compareResult < 0)
			current.left = addRecursively(current.left, key);
		else
			current.right = addRecursively(current.right, key);
		return current;	
	}

	public boolean search(K val) 
	{
		return searchRecursively(root, val);
	}

	private boolean searchRecursively(MyBinaryNode<K> r, K val) 
	{
		boolean found = false;
		while ((r != null) && !found) 
		{
			K rval = r.key;
			if (val.compareTo(rval) < 0)
				r = r.left;
			else if (val.compareTo(rval) > 0)
				r = r.right;
			else 
			{
				found = true;
				break;
			}
			found = searchRecursively(r, val);
		}
		return found;
	}

	public int getSize() {
		return this.getSizeRecursive(root);
	}

	private int getSizeRecursive(MyBinaryNode<K> current) {
		return current == null ? 0 : 1 + this.getSizeRecursive(current.left) + this.getSizeRecursive(current.right);
	}
}
