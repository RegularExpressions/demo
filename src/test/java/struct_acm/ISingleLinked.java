package struct_acm;

import lombok.Data;
import lombok.ToString;

public interface ISingleLinked {
    @Data
    @ToString
    class HeroNode {
        private int no;
        private String name;
        private String nickName;
        @ToString.Exclude
        private HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }
    }

    HeroNode getHead();

    /**
     * 添加单链表节点
     * @param node
     */
    void add(HeroNode node);

    /**
     * 按照正序添加单链表节点
     * @param node
     */
    void addBySort(HeroNode node);

    /**
     * 根据编号移除对应单链表节点
     * @param no
     */
    void delete(int no);

    /**
     * 根据编号修改对应单链表节点
     * @param node
     */
    void update(HeroNode node);

    /**
     * 根据编号获取对应单链表节点
     * @param no
     * @return
     */
    HeroNode get(int no);

    /**
     * 按照正序打印单链表
     */
    void printLinked();

    /**
     * 寻找倒数第k个单链表节点 -- 利用单链表节点有效个数实现
     * @param k
     * @return
     */
    HeroNode findKNumNode1(int k);

    /**
     * 寻找倒数第k个单链表节点 -- 利用快慢指针实现
     * @param k
     * @return
     */
    HeroNode findKNumNode2(int k);

    /**
     * 单链表反转 -- 通过创建新的头节点，遍历原链表，将原链表各个节点按照头插法插入新头节点实现
     */
    void reverse1();

    /**
     * 单链表反转 -- 通过创建三个临时变量，pre，cur，next；在遍历链表的同时完成反转
     */
    void reverse2();


    /**
     * 反向遍历--递归实现
     */
    void reversePrint();

    /**
     * 反向遍历--利用栈实现
     */
    void reversePrintByStack();

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     */
    ISingleLinked unionLinked(ISingleLinked second);
}
