#include<stdio.h>
#include<conio.h>
int a[100];
int binsearch(int l,int h,int si)
{
	int m;
	while(l<=h)
	{
		m=(l+h)/2;
		if((si<a[m])&&(l<h))
		h=m-1;
		else if((si>a[m])&&(l<h))
		l=m+1;
		else if(si==a[m])
		return m+1;
		else if((si<a[m])&&(l==h))
		return m;
		else if((si>a[m])&&(l==h))
		return m+1;
	
	}
	
}
void inssort(int n)
{
	int i,select,l,j;
	for(i=1;i<n;i++)
	{
		select=a[i];
		j=i-1;
		l=binsearch(0,j,select);
		while(j>=l)
		{
			a[j+1]=a[j];
			j--;
		}
		a[j+1]=select;
		
	}
}
int main()
{
	int n,i;
	printf("enter number of values\n");
	scanf("%d",&n);
	printf("enter the values\n");
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	inssort(n);
	printf("sorted array is\n");
	for(i=0;i<n;i++)
	{
		printf("%d ",a[i]);
	}
	return 0;
	
}
