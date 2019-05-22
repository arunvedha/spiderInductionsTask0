#include <iostream>
using namespace std;
 
#define INF 9999999
int V;


int G[50][50];


 
int main () {
 
  int no_edge;      
  int selected[50];
  
  cin>>V;
  for(int i = 0; i < V; i++){
  	for(int j = 0;j < V;j++){
  		cin>>G[i][j];
	  }
  }
  
 for(int i = 0;i<V;i++){
   selected[i] = false;
 }
  no_edge = 0;
  selected[0] = true;
 
  int x;          
  int y;  
  cout << "Edge" << " : " << "Weight"<<endl;
  while (no_edge < V - 1) {
      int min = INF;
      x = 0;
      y = 0;
 
      for (int i = 0; i < V; i++) 
        if (selected[i]) 
            for (int j = 0; j < V; j++)
              if (!selected[j] && G[i][j]) 
                  if (min > G[i][j]) {
                      min = G[i][j];
                      x = i;
                      y = j;
                  } 
      
             
      cout << x <<  " - " << y << " :  " << G[x][y];
      cout << endl;
      selected[y] = true;
      no_edge++;
    }
 
  return 0;
}
