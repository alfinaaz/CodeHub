class Solution {
public:
    
    int get_max_hist(vector<int> v){
        stack<int> st;
        int n = v.size();
        int ans = 0;
        for(int i =0;i<=n;i++){
            while(st.empty()==false and (i==n or v[st.top()]>=v[i])){
                int h = v[st.top()];
                st.pop();
                int w = st.empty()==true?i:i-st.top()-1;
                cout<<h<<" "<<w<<"\n";
                ans = max(ans, min(h,w)*min(h,w));
            }
            st.push(i);
        }
        // cout<<ans<<"\n";
        return ans;
    }
    
    int maximalSquare(vector<vector<char>>& matrix) {
    
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> mat(n,vector<int>(m,0));
        for(int i =0;i<m;i++){
            mat[0][i] = matrix[0][i]=='1'?1:0;
        }
        for(int i =1;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j]=='1') mat[i][j] = 1+ mat[i-1][j];
                else mat[i][j] = 0;
            }
        }
        int ans = 0;
        for(int i =0;i<n;i++){
            ans = max(ans, get_max_hist(mat[i]));
        }
        return ans;
        
    }
};