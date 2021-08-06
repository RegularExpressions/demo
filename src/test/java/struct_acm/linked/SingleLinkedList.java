package struct_acm.linked;

import java.util.Stack;

public class SingleLinkedList implements ISingleLinked {

    public static void main(String[] args) {
        ISingleLinked singleLinkedList = new SingleLinkedList();
        basicTest(singleLinkedList);
        ISingleLinked first = new SingleLinkedList();
        ISingleLinked second = new SingleLinkedList();
        HeroNode hero2 = new HeroNode(2, "宋江", "及时雨");
        HeroNode hero5 = new HeroNode(5, "卢俊义", "玉麒麟");
        first.addBySort(hero5);
        first.addBySort(hero2);
        HeroNode hero1 = new HeroNode(1, "吴用", "智多星");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero8 = new HeroNode(8, "孙二娘", "母夜叉");
        second.addBySort(hero1);
        second.addBySort(hero6);
        second.addBySort(hero8);
        ISingleLinked unionLinked = second.unionLinked(first);
        System.out.println("~~~~~~~~~~~合并两个有序链表后第1个链表~~~~~~~~~~~");
        first.printLinked();
        System.out.println("~~~~~~~~~~~合并两个有序链表后第1个链表~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~合并两个有序链表后第2个链表~~~~~~~~~~~");
        second.printLinked();
        System.out.println("~~~~~~~~~~~合并两个有序链表后第2个链表~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~合并两个有序链表~~~~~~~~~~~");
        unionLinked.printLinked();
        System.out.println("~~~~~~~~~~~合并两个有序链表~~~~~~~~~~~");
    }

    private static void basicTest(ISingleLinked singleLinkedList) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        singleLinkedList.addBySort(hero1);
        singleLinkedList.addBySort(hero3);
        singleLinkedList.addBySort(hero4);
        singleLinkedList.addBySort(hero2);
        singleLinkedList.printLinked();
        System.out.println("~~~~~~~~~~~反向遍历~~~~~~~~~~~");
        singleLinkedList.reversePrint();
        System.out.println("~~~~~~~~~~~反向遍历~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~利用栈实现反向遍历~~~~~~~~~~~");
        singleLinkedList.reversePrintByStack();
        System.out.println("~~~~~~~~~~~利用栈实现反向遍历~~~~~~~~~~~");
        System.out.println();
        System.out.println(singleLinkedList.get(3));
        System.out.println("~~~~~~~~~~~修改前~~~~~~~~~~~");
        singleLinkedList.update(new HeroNode(2, "小卢", "玉麒麟"));
        singleLinkedList.printLinked();
        System.out.println("~~~~~~~~~~~修改后~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~删除前~~~~~~~~~~~");
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);
        singleLinkedList.delete(4);
        singleLinkedList.printLinked();
        System.out.println("~~~~~~~~~~~删除后~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~倒数第1个节点为~~~~~~~~~~~");
        System.out.println(singleLinkedList.findKNumNode1(1));
        System.out.println(singleLinkedList.findKNumNode1(2));
    }


    private final HeroNode head;

    public SingleLinkedList() {
        head = new HeroNode(-1, "", "");
    }

    public SingleLinkedList(HeroNode head){
        if(head != null){
            this.head = head;
        }else {
            this.head = new HeroNode(-1, "", "");
        }
    }

    @Override
    public HeroNode getHead() {
        return head;
    }

    @Override
    public void add(HeroNode node) {
        HeroNode cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(node);
    }

    @Override
    public void addBySort(HeroNode node) {
        HeroNode cur = head;
        boolean isRepeat = false;
        while (cur.getNext() != null) {
            if (cur.getNext().getNo() == node.getNo()) {
                isRepeat = true;
                break;
            } else if (cur.getNext().getNo() > node.getNo()) {
                break;
            }
            cur = cur.getNext();
        }

        if (isRepeat) {
            System.out.println("节点已存在，不需要重复添加");
        } else {
            node.setNext(cur.getNext());
            cur.setNext(node);
        }
    }

    @Override
    public void delete(int no) {
        HeroNode cur = head;
        boolean isFind = false;
        while (cur.getNext() != null) {
            if (cur.getNext().getNo() == no) {
                isFind = true;
                break;
            }
            cur = cur.getNext();
        }

        if (isFind) {
            cur.setNext(cur.getNext().getNext());
        }
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
    public HeroNode get(int no) {
        HeroNode cur = head.getNext();

        while (cur != null) {
            if (cur.getNo() == no) {
                return cur;
            }
            cur = cur.getNext();
        }

        return null;
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
    public HeroNode findKNumNode1(int k) {
        HeroNode cur = head.getNext();
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }

        if (k <= 0 || k > count) {
            System.out.println("k值超出索引界限，最大值为:" + count + ",当前输入k值为:" + k + "");
            return null;
        }

        HeroNode temp = head.getNext();
        for (int i = 0; i < count - k; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    @Override
    public HeroNode findKNumNode2(int k) {
        int count = size();
        if (k <= 0 || k > count) {
            System.out.println("k值超出索引界限，最大值为:" + count + ",当前输入k值为:" + k + "");
            return null;
        }
        HeroNode slow = head;
        HeroNode quick = head;

        for (int i = 0; i < k; i++) {
            quick = quick.getNext();
        }

        while (quick != null) {
            slow = slow.getNext();
            quick = quick.getNext();
        }

        return slow;
    }

    private int size() {
        HeroNode cur = head.getNext();
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    /**
     * 反转单链表1 -- 创建一个新头节点，遍历原单链表，将各个元素采用头插法插入新头节点，最后再将原头节点指向已反转的链表即可
     */
    @Override
    public void reverse1() {
        HeroNode cur = head.getNext();
        if (cur == null || cur.getNext() == null) {
            return;
        }

        HeroNode reHead = new HeroNode(-1, "", "");
        while (cur != null) {
            HeroNode next = cur.getNext();
            cur.setNext(reHead.getNext());
            reHead.setNext(cur);
            cur = next;
        }

        head.setNext(reHead.getNext());
    }

    /**
     * 反转单链表2 -- 建立三个临时变量，遍历单链表时分别指向当前节点（cur），相对当前节点的前一个节点（pre），相对当前节点的后一个节点（next）
     */
    @Override
    public void reverse2() {
        HeroNode cur = head.getNext();
        if (cur == null || cur.getNext() == null) {
            return;
        }
        HeroNode pre = null;
        while (cur != null) {
            if (cur.getNext() == null) {
                head.setNext(cur);
            }
            HeroNode next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
    }


    private void reversePrint(HeroNode cur) {
        if (cur == null) {
            return;
        }
        reversePrint(cur.getNext());
        System.out.println(cur);
    }

    @Override
    public void reversePrint() {
        reversePrint(head.getNext());
    }

    @Override
    public void reversePrintByStack() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.getNext();

        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    @Override
    public ISingleLinked unionLinked(ISingleLinked secondLinked) {
        HeroNode secondH = secondLinked.getHead();
        if (head.getNext() == null) {
            return new SingleLinkedList(secondH);
        }
        if (secondH == null || secondH.getNext() == null) {
            return new SingleLinkedList(head);
        }
        HeroNode cur1 = head.getNext();
        HeroNode cur2 = secondH.getNext();
        HeroNode resultH = new HeroNode(-1, "", "");

        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                while (cur2 != null) {
                    add(resultH, cur2);
                    cur2 = cur2.getNext();
                }
                break;
            }
            if (cur2 == null) {
                while (cur1 != null) {
                    add(resultH, cur1);
                    cur1 = cur1.getNext();
                }
                break;
            }

            if (cur1.getNo() < cur2.getNo()) {
                add(resultH, cur1);
                cur1 = cur1.getNext();
            } else {
                add(resultH, cur2);
                cur2 = cur2.getNext();
            }
        }
        return new SingleLinkedList(resultH);
    }

    private void add(HeroNode head, HeroNode node) {
        HeroNode cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        HeroNode element = new HeroNode(node.getNo(),node.getName(),node.getNickName());
        cur.setNext(element);
    }


}
