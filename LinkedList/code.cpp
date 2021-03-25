#include<iostream>
#include<bits/stdc++.h>
using namespace std;


class Node
{
public:
	int data;
	Node* next;
};

Node* head=NULL;
Node* ll=NULL;
Node* tail=NULL;

void add(int c)
{

	if(ll==NULL)
	{
		ll=new Node;
		ll->data=c;
		ll->next = NULL;
		head = ll;
		tail = ll;
	}

	else
	{
		Node* temp = new Node;
		temp->data = c;
		temp->next=NULL;
		tail->next = temp;
		tail = tail->next;
		temp = tail;
	}
}


void display()
{
	Node* show = head;

	while(show!=NULL)
	{
		cout<<show->data<<" ";
		show = show->next;
	}
}


int main()
{

	int n;
	int c;
	cin>>n;


	for(int i=0;i<n;i++)
	{
		cin>>c;

		add(c);
	}
	display();


	return 0;
}