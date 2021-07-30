package struct_acm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class SingleLinkedDemo {
    private final HeroNode head;

    public SingleLinkedDemo() {
        head = new HeroNode(-1, "", "", null);
    }


    @Data
    @AllArgsConstructor
    static class HeroNode {
        private int no;
        private String name;
        private String nickName;
        @ToString.Exclude
        private HeroNode next;
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(HeroNode node) {
        HeroNode cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = node;
    }

    /**
     * 按照正序添加
     *
     * @param node
     */
    public void addSort(HeroNode node) {
        HeroNode cur = head;

        boolean isRepeat = false;
        while (true) {
            if (cur.next == null) break;

            if (cur.next.no > node.no) break;
            else if (cur.next.no == node.no) {
                isRepeat = true;
                break;
            }

            cur = cur.next;
        }

        if(isRepeat){
            System.out.println("节点已存在，不需要重复添加");
        }else {
            //将节点插入
            node.next = cur.next;
            cur.next = node;
        }

    }

    /**
     * 根据编号删除节点
     * @param no
     */
    public void delete(int no){
        HeroNode cur = head;

        boolean isFind = false;
        while (cur.next != null){
            if(cur.next.no == no){
                isFind = true;
                break;
            }
            cur = cur.next;
        }

        if(isFind){
            cur.next = cur.next.next;
        }
    }

    /**
     * 更新节点
     * @param node
     */
    public void update(HeroNode node){
        HeroNode cur = head.next;

        boolean isFind = false;
        while (cur != null){
            if(cur.no == node.no){
                isFind = true;
                break;
            }
            cur = cur.next;
        }

        if(isFind){
            cur.nickName = node.nickName;
            cur.name = node.name;
        }
    }

    /**
     * 打印链表
     */
    public void printLinked(){
        HeroNode cur = head.next;

        while (cur!= null){
            System.out.println(cur);
            cur = cur.next;
        }
    }

    /**
     * 通过编号获取对应节点
     * @param no
     */
    public HeroNode get(int no){
        HeroNode cur = head.next;
        while (cur!=null){
            if(cur.no == no){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 获取单链表倒数第K个节点
     * @param k
     * @return
     */
    public HeroNode findKNumNode1(int k){
       HeroNode cur = head.next;

       int count = 0; //记录单链表有效元素个数
       while (cur!=null){
           count++;
           cur = cur.next;
       }

       if(k<=0 || k>count){
           System.out.println("k值超出索引界限，最大值为:"+count+",当前输入k值为:"+k+"");
           return null;
       }

       HeroNode kNumNode = head.next;
       for(int i=0;i<count-k;i++){
           kNumNode = kNumNode.next;
       }
       return kNumNode;
    }

    /**
     * 获取单链表倒数第K个节点 -- 快慢指针
     * @param k
     * @return
     */
    public HeroNode findKNumNode2(int k){
        if(k<=0 || k>size()){
            System.out.println("k值超出索引界限，最大值为:"+size()+",当前输入k值为:"+k+"");
            return null;
        }

        HeroNode slow = head;
        HeroNode quick = head;

        for(int i=0;i<k;i++){
            quick = quick.next;
        }

        while (quick!=null){
            quick = quick.next;
            slow = slow.next;
        }

        return slow;

    }

    private int size(){
        int count = 0;
        HeroNode cur = head.next;

        while (cur!= null){
            count++;
            cur = cur.next;
        }
        return count;
    }


    /**
     * 反转单链表1 -- 创建一个新头节点，遍历原单链表，将各个元素采用头插法插入新头节点，最后再将原头节点指向已反转的链表即可
     */
    public void reverse1(){
        //单链表为空或者单链表只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null){
            return;
        }
       HeroNode reverseHead = new HeroNode(-1,"","",null);

        HeroNode cur = head.next;
        HeroNode next;
        while (cur!= null){
            next = cur.next;

            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        head.next = reverseHead.next;
    }


    /**
     * 反转单链表2 -- 建立三个临时变量，遍历单链表时分别指向当前节点（cur），相对当前节点的前一个节点（pre），相对当前节点的后一个节点（next）
     */
    public void reverse2(){
        //单链表为空或者单链表只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null){
            return;
        }

        HeroNode cur = head.next;
        HeroNode pre  = null;
        while (cur!= null){
            if(cur.next == null){
                head.next = cur;
            }
            HeroNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

    }



}
