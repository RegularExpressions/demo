package struct_acm;

import lombok.Data;
import lombok.ToString;

public interface IDoubleLinked {
    @Data
    @ToString
    class HeroNode{
        private int no;
        private String name;
        private String nickName;
        @ToString.Exclude
        private HeroNode pre;
        @ToString.Exclude
        private HeroNode next;

        public HeroNode(int no,String name,String nickName){
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }
    }

    /**
     * 获取头节点
     * @return
     */
    HeroNode getHead();

    HeroNode getRoot();

    /**
     * 打印链表
     */
    void printLinked();

    /**
     * 反向打印链表
     */
    void reversePrintLinked();

    /**
     * 添加节点
     * @param node
     */
    void add(HeroNode node);

    /**
     * 按照正序添加单链表节点
     * @param node
     */
    void addBySort(HeroNode node);
    /**
     * 更新节点
     * @param node
     */
    void update(HeroNode node);

    /**
     * 删除节点
     * @param no
     */
    void delete(int no);

    /**
     * 根据编号查找对应节点，可指定从链表尾还是链表头开始寻找
     * @param no  编号
     * @param isForward true 表示从链表尾开始找，
     *                  false表示从链表头开始找
     * @return
     */
    HeroNode get(int no,boolean isForward);


}
