package pqueue;

import java.util.ArrayList;
import java.util.Collections;

public class PQueue<T extends Comparable> {
	ArrayList<T> PQ;

	PQueue() {
		PQ = new ArrayList<T>();
	}

	void push(T t) {
		PQ.add(t);
	}

	T pop() throws EmptyQueueException {
		if (PQ.isEmpty()) {
			throw new EmptyQueueException("The Array is empty!");
		}
		Comparable max = Collections.max(PQ);
		PQ.remove(max);
		return (T) max;
	}

	T top() throws EmptyQueueException {
		if (PQ.isEmpty()) {
			throw new EmptyQueueException("The Array is empty!");
		}
		Comparable max = Collections.max(PQ);
		return (T) max;
	}

	int size() {
		return PQ.size();
	}

	void clear() {
		PQ.clear();
	}

	void foreach() {

	}
}
