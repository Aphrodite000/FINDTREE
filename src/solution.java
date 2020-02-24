import java.util.Arrays;

public class solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        //二叉搜索树左子树都比跟结点小，右子树逗比根节点大
        //首先找出根节点，然后遍历找出第一个比根节点大的结点
        //看他的右边，如果右边有比根节点小的则返回false；
        //如果没有就去左右子树找，看左右子树是否为二叉搜索树
        if(sequence.length==0||sequence==null){
            return false;
        }
        int root=sequence[sequence.length-1];
        int i;
        for(i=0;i<sequence.length-1;i++){
            if(sequence[i]>root){
                break;
            }
        }
        for(int j=i;j<sequence.length-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }

        boolean left=true;//左树
        boolean right=true;//右树
        if(i>0){
            left=VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        if(i<sequence.length-1)
            right=VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
        return (left&&right);
    }
}
