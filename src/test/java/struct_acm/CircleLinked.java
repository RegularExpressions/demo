package struct_acm;

import lombok.Data;
import lombok.ToString;

public class CircleLinked {

    public static void main(String[] args) {
        CircleLinked circleLinked = new CircleLinked();
        circleLinked.add(new Boy(1));
        circleLinked.add(new Boy(2));
        circleLinked.add(new Boy(3));
        circleLinked.add(new Boy(4));
        circleLinked.add(new Boy(5));
        circleLinked.list();
        System.out.println();
        circleLinked.josephu(1,2,5);

    }

    @Data
    @ToString
    static class Boy {
        private int no;
        @ToString.Exclude
        private Boy next;

        public Boy(int no) {
            this.no = no;
        }
    }

    private Boy first;
    private int size = 0;

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Boy node) {
        if (first == null) {
            first = node;
            first.next = first;
            size++;
        } else {
            Boy cur = first;
            while (cur.next != first) {
                cur = cur.next;
            }
            cur.next = node;
            node.next = first;
            size++;
        }
    }

    /**
     * 打印环形链表
     */
    public void list() {
        Boy cur = first;
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        do {
            System.out.println(cur);
            cur = cur.next;
        } while (cur != first);
    }

    /**
     * @param startNo  表示从第几个节点开始数数
     * @param countNum 表示数几下，当前节点也算一下
     * @param nums     表示环状链表有多少节点
     */
    public void josephu(int startNo, int countNum, int nums) {
        if (first == null) return;
        if (startNo < 1 || startNo > nums || nums != size) {
            System.out.println("参数输入有误");
            return;
        }
        if(first.next == first) {
            System.out.println(first);
            return;
        }

        Boy cur = first;
        for (int i = 1; i < startNo; i++) {
           cur = cur.next;
           first = first.next;
        }

        while (cur.next != first){
            cur = cur.next;
        }

        while (cur != first){
            for (int i=0;i<countNum-1;i++){
                first = first.next;
                cur = cur.next;
            }
            System.out.println(first);
            first = first.next;
            cur.next = first;
        }
        System.out.println(first);

    }


}
