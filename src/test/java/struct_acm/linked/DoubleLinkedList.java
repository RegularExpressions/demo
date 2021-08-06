package struct_acm.linked;

/**
 * 双向链表
 */
public class DoubleLinkedList implements IDoubleLinked {
    public static void main(String[] args) {

    }

    private final HeroNode head;
    private HeroNode root;

    public DoubleLinkedList() {
        this.head = new HeroNode(-1, "", "");
        this.root = head;
    }

    @Override
    public HeroNode getHead() {
        return head;
    }

    @Override
    public HeroNode getRoot() {
        return root;
    }

    @Override
    public void printLinked() {
        HeroNode cur = head.getNext();
        while (cur != null) {
            System.out.println(cur);
            cur = cur.getNext();
        }
    }

    @Override
    public void reversePrintLinked() {
        HeroNode cur = root.getPre();
        while (cur!=null){
            System.out.println(cur);
            cur = cur.getPre();
        }
    }

    @Override
    public void add(HeroNode node) {
        HeroNode cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        node.setPre(cur);
        cur.setNext(node);
        this.root = node;
    }

    @Override
    public void addBySort(HeroNode node) {

    }


    @Override
    public void update(HeroNode node) {
        HeroNode cur = head.getNext();
        boolean isFind = false;
        while (cur != null) {
            if (cur.getNo() == node.getNo()) {
                isFind = true;
                break;
            }
            cur = cur.getNext();
        }

        if (isFind) {
            cur.setName(node.getName());
            cur.setNickName(node.getNickName());
        }
    }

    @Override
    public void delete(int no) {
        HeroNode cur = head.getNext();
        boolean isFind = false;
        while (cur != null) {
            if (cur.getNo() == no) {
                isFind = true;
                break;
            }
            cur = cur.getNext();
        }

        if (isFind) {
            cur.getPre().setNext(cur.getNext());
            if (cur.getNext() != null) {
                cur.getNext().setPre(cur.getPre());
            } else {
                this.root = cur.getPre();
            }
        }

    }

    @Override
    public HeroNode get(int no, boolean isForward) {
        if (isForward) {
            HeroNode cur = root.getPre();

            while (cur != null) {
                if (no == cur.getNo()) {
                    return cur;
                }
                cur = cur.getPre();
            }

        } else {
            HeroNode cur = head.getNext();

            while (cur != null) {
                if (no == cur.getNo()) {
                    return cur;
                }
                cur = cur.getNext();
            }

        }
        return null;
    }
}
