package com.cdsf.utils.tree;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkedList a = new TreeLinkedList();
		TreeLinkedList b = new TreeLinkedList();
		TreeLinkedList c = new TreeLinkedList();
		TreeLinkedList d = new TreeLinkedList();
		TreeLinkedList e = new TreeLinkedList();
		TreeLinkedList f = new TreeLinkedList();
		TreeLinkedList g = new TreeLinkedList();

		a = new TreeLinkedList(null, 0, d, null);
		b = new TreeLinkedList(a, 1, d, c.getFirstChild());
		c = new TreeLinkedList(a, 2, null, null);
		d = new TreeLinkedList(b, 3, f, e.getFirstChild());
		e = new TreeLinkedList(b, 4, null, null);
		f = new TreeLinkedList(d, 5, null, g.getFirstChild());
		g = new TreeLinkedList(d, 6, null, null);

		System.out.println(a.getDepth());
		System.out.println(b.getDepth());
		System.out.println(c.getDepth());
		System.out.println(d.getDepth());
		System.out.println(e.getDepth());
		System.out.println(f.getDepth());

		System.out.println(a.getHeight());
		System.out.println(b.getHeight());
		System.out.println(c.getHeight());
		System.out.println(d.getHeight());
		System.out.println(e.getHeight());
		System.out.println(f.getHeight());
		System.out.println(g.getHeight());

	}
}
