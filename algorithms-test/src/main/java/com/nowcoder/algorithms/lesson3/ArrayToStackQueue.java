package com.nowcoder.algorithms.lesson3;

public class ArrayToStackQueue {

	/**
	 * 用数组实现栈
	 * 只需要增加一个指针，指在栈顶的位置。同数组长度一起，两个变量即可确定一个栈结构。
	 *
	 * push：判断指针是否超过数组长度，如果没超过，把入栈数字放入index++位置。
	 * pop：判断指针是否为0，不为零，则弹出--index的数值
	 * peek：返回index-1位置的数。
	 */
	public static class ArrayStack {
		private Integer[] arr;
		//当前指针
		private Integer index;

		public ArrayStack(int initSize) {
			if (initSize < 0) {
					throw new IllegalArgumentException("The init index is less than 0");
			}
			arr = new Integer[initSize];
			index = 0;
		}

		public Integer peek() {
			if (index == 0) {
				return null;
			}
			return arr[index - 1];
		}

		public void push(int obj) {
			if (index == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			arr[index++] = obj;
		}

		public Integer pop() {
			if (index == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--index];
		}
	}

	/**
	 * 用数组实现队列
	 * 用三个变量来描述队列。
	 * size：数组当前使用了的长度
	 * start：数组起始位置
	 * end：数组尾部，每添加一个
	 */
	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;
		private Integer first;
		private Integer last;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init index is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			first = 0;
			last = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[last] = obj;
			last = last == arr.length - 1 ? 0 : last + 1;
		}

		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = first;
			first = first == arr.length - 1 ? 0 : first + 1;
			return arr[tmp];
		}
	}

	public static void main(String[] args) {

	}

}
