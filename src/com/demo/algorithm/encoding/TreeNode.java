package com.demo.algorithm.encoding;

public interface TreeNode<T> {
    /** Returns the left child of this node
     *
     * @return the left child of this node
     */
    TreeNode<T> getLeftChild();

    /** Returns the right child of this node
     *
     * @return the right child of this node
     */
    TreeNode<T> getRightChild();

    /** Returns the value stored in this node
     *
     * @return the value stored in this node
     */
    T getValue();
}
