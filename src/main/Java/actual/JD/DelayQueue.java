package actual.JD;

public class DelayQueue {

    private static Element[] queue = new Element[10];

    public static void main(String[] args) {

    }

    public static void put(Element element) {

        Element[] nQueue = new Element[queue.length + 1];
        System.arraycopy(queue, 0, nQueue, 0, nQueue.length);
        nQueue[nQueue.length - 1] = element;
        int left = 0, right = nQueue.length;
        quickSort(nQueue, left, right);
        queue = new Element[queue.length + 1];
        System.arraycopy(nQueue, 0, queue, 0, queue.length + 1);
    }

    private static void quickSort(Element[] queue, int left, int right) {
        if (left < right) {
            int index = partition(queue, left, right);
            quickSort(queue, left, index - 1);
            quickSort(queue, index + 1, right);
        }
    }

    private static int partition(Element[] queue, int left, int right) {
        if (left < right) {
            swap(queue, left, left + (int) (Math.random() * (right - left + 1)));
        }
        Element p = queue[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (queue[i].time <= p.time) {
                swap(queue, index, i);
                index++;
            }
        }
        swap(queue, index, left);
        return index;
    }

    private static void swap(Element[] queue, int left, int right) {
        if (left == right) {
            return;
        }
        Element t = queue[left];
        queue[left] = queue[right];
        queue[right] = t;
    }

    public static Element get() {
        return queue[0];
    }

    static class Element {

        String val;
        long time;

        public Element(String val, long time) {
            this.val = val;
            this.time = time;
        }
    }
}
