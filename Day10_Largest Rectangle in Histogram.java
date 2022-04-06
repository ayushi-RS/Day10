 public int largestRectangleArea(int[] arr) {
        
        int n = arr.length;
        if(n==1) {
            return arr[0];
        }
        if(n==2) {
            if(arr[0] == 0 || arr[1] == 0) {
                return (arr[0] == 0 ? arr[1] : arr[0]); 
            } else {
                if(arr[0] < arr[1]) {
                    return Math.max(2*arr[0], arr[1]);    
                } else {
                    return Math.max(arr[0], 2*arr[1]);
                }
                
            }
        }
        int[] rb = new int[n];
        Stack<Integer> rst = new Stack<>();
        rst.push(n-1);
        rb[n-1] = n;
        for(int i = n-2; i>=0; i--) {
            while(rst.size()>0 && arr[rst.peek()] >= arr[i]) {
                rst.pop();
            }
            
            if(rst.size() == 0) {
                rb[i] = n;
            } else {
                rb[i] = rst.peek();
            }
            rst.push(i);
        }
        
        int[] lb = new int[n];
        Stack<Integer> lst = new Stack<>();
        lst.push(0);
        rb[0] = -1;
        for(int i = 0; i<n; i++) {
            while(lst.size()>0 && arr[lst.peek()] >= arr[i]) {
                lst.pop();
            }
            
            if(lst.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = lst.peek();
            }
            lst.push(i);
        }
        
        int mxArea = arr[0];
        for(int i=0; i<n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width*arr[i];
            mxArea = Math.max(mxArea, area);
        }
        
        return mxArea;
    }