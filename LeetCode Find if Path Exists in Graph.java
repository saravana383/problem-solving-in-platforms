class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        ArrayList<Integer>[] grp = new ArrayList[n];
        for(int i=0;i<n;i++){
            grp[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v= edges[i][1];

            grp[u].add(v);
            grp[v].add(u);
        }
        boolean [] visit =new boolean [n];
        return dfs(grp,visit,src,des);
    }
    public boolean dfs(ArrayList<Integer>[] grp, boolean[] visit, int src,int des){
        if(src==des) return true;
        visit[src]=true;
        for(int neb:grp[src]){
            if(visit[neb]== false){
            boolean ans = dfs(grp,visit,neb,des);
            if(ans) return true;
            }
        }
        return false;
    }
}