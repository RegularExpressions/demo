package struct_acm.recursion;

/**
 * 迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        //创建二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //把1 作为迷宫的墙
        //把上下 置为1
        for (int i=0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //把左右 置为1
        for (int i=0;i<8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
        //输出地图

        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        System.out.println("找完路径，地图如下：");
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    /**
     * 使用递归回溯来给小球找路
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到出迷宫的路，就返回true，否则返回false
     * 如果小球能到达map[6,5]，说明找到出迷宫的路，当map[i][j]为1表示墙，不能走
     *  为0 表示该点还没有走过，如果为2 表示通路可以走，如果为3 表示该点已经走过，但走不通
     *
     *  走迷宫时，指定一个策略 下-》右-》上-》左 即优先往下走，下走不通，走右，以此类推
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
