public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "{label:" + label + "," + "hashCode:" + this.hashCode() + "," + "random:"
                + (random == null ? 0 : random.hashCode()) + "}" + "\n" + next;
    }
}
