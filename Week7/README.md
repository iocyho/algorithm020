## 本周学习内容

本周的内容乍一看很多，视频很长，部分内容也很晦涩难懂，但稍微一总结，发现主要也就分为三部分

##### 一、需要强记的

1. 字典树--用于解决单词联想、词频统计等问题

   ```python
   class Trie(object):
   	def __init__(self):
           self.root = {}
           self.end_of_word = "#"
           
       def insert(self, word):
           node = self.root
           for char in word:
           	node = node.setdefault(char, {})
           node[self.end_of_word] = self.end_of_word
           
       def search(self, word):
           node = self.root
           for char in word:
           	if char not in node:
           		return False
           	node = node[char]
           return self.end_of_word in node
       
       def startsWith(self, prefix):
           node = self.root
           for char in prefix:
           	if char not in node:
           		return False
          		node = node[char]
           return True
   ```

   

2. 并查集--解决组团、配对问题

   ```java
   class UnionFind {
       private int count = 0;
       private int[] parent;
       
       public UnionFind(int n) {
           count = n;
           parent = new int[n];
           for (int i = 0; i < n; i++) {
               parent[i] = i;
           }
       }
       
       public int find(int p) {
           while (p != parent[p]) {
               parent[p] = parent[parent[p]];
               p = parent[p];
           }
           return p;
       }
       
       public void union(int p, int q) {
           int rootP = find(p);
           int rootQ = find(q);
           if (rootP == rootQ) return;
           parent[rootP] = rootQ;
           count--;
       }
   }
   ```

   

##### 二、需要理解并灵活运用的(核心内容)

1. 减枝
   * 在搜索过程中提前把不可能找到目标值的路径排除，减少做无用功
2. 双向BFS
   * BFS的进阶版，多用于图的搜索
   * 从起点和终点同时向中间搜索，相遇后说明搜索完毕
   * 总的来说其实是运用**分治**思想来提高搜索效率
3. A*
   * 本质上也还是BFS的进阶版
   * 通过"估价函数"来提前预判可能性更高的目标，从而实现搜索优化
   * 所谓"估计函数"本质上就是一种**减枝**，预判可能性更高的目标即意味着对可能性低的进行减枝

##### 三、只需要大致了解即可的

* 二叉树     -- 只有每个节点的子节点数据小于等于2

* 二叉搜索树 -- 在二叉树的基础上，左子树的所有节点大于根节点，右子树的所有节点小于根节点，以此类推。中序遍历时，是升序排列的

* 平衡二叉树 -- 在极端情况下，二叉搜索树会退化成链表(每个节点只有左子节点，或者只有右子节点)，为了解决这个问题，需要保证树的左右高度相对平衡，即为平衡二叉树。具体的实现方式有很多，常见的实现包括：AVL树、红黑树、23树、伸展树、B+树...

* AVL树--**<font color="green">严格平衡的二叉树</font>**,核心是**保证左右子树的深度差不大于1**

     * 由于二叉搜索树的查询效率取决于树的深度。因此引入平衡因子（左子树【高度】-右子树【高度】，有时相反，balance factory = {-1 0 1}）来记录深度，从而实现左右子树的深度差不大于1。

     * 具体做法：每次增删完节点后，都判断树是否平衡，如果不平衡，则挪动节点位置保持平衡。
     * 缺点是每个节点需要记录额外的信息(int类型，因为需要加减计算)，且调整次数频繁

* 红黑树--**<font color="orange">近似平衡的二叉树</font>**，核心是**确保任何一个节点的左右子树高度差小于两倍**
  *  具体通过在每个节点记录额外的"颜色信息"来实现		
    1. 每个节点要么红色，要么黑色
    2. 根节点是黑色
    3. 每个叶子节点（所有叶子节点都是NIL节点，即空节点）是黑色的
    4. 不能有两个相邻的红色节点
    5.  从任一节点到其叶子节点的所有路径都包含数量相同的黑色节点。
  * 由于只额外存储"颜色信息"，因此只需要1个bit即可

* AVL树与红黑树对比
  * 都是为了解决二叉搜索树增删节点可能导致的性能退化问题。
  * AVL或红黑树的具体做法：每次增删完节点后，都判断树是否平衡，如果不平衡，则挪动节点位置保持平衡。
  * 都是通过记录额外的信息，来实现对**平衡**的计算
  * 区别在于**二者对平衡的要求不同**，AVL树为了严格平衡，额外记录了更多的信息，消耗更多的空间，也牺牲了维护效率。红黑树妥协为近似平衡，牺牲了一部分读取效率，换来空间消耗更小、更易于维护的优势。
  * 使用场景：
    * 当<font color="green">读很频繁，写很少的情况下，用AVL树</font>
    * 当<font color="orange">读写频率相当时，用红黑树</font>

## 主要难点
1. 内容比较杂，而且课程时长也是之前的几倍，需要花更多时间梳理。
2. 工作上的问题更多，还是找不出更多时间练代码。

## 主要收获

1. 对树、二叉树、二叉搜索树、平衡二叉树、AVL树、红黑树这一系列概念把握到了一个比较完整的脉络。之前看一些书籍、文档时感觉莫名其妙的概念终于都串起来了。
2. 坚持本身就是最大的收获

