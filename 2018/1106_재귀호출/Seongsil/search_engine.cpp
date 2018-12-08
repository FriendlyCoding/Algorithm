/*���� �˻�����

2018/12/06 
Seongsil Heo
*/

#include <iostream>
#include <string>
#include <map>
#include <vector>

using namespace std;
int score(vector<string> cnt[], map<string,int> &m,string alpha);

int main(void){

	int cases;
	string afta;
	map<string, int> m; // key: A, value:0 | key:B, value:1 ...
	int n;

	vector<string> cnt[51];

	cin >> cases;
	for (int i = 0; i < cases; i++)
	{
		cin >> afta;
		cin >> n;
		int mcnt = 0;

		if (!m[afta]) // KEY�� Value�� �������� �ʴ� ���, value�� ��������
		{
			m[aefa] = mcnt++;
		}

		for (int j = 0; j < n; j++)
		{
			string befa;
			cin >> befa;
			if (!m[befa])
			{
				m[befa] = mcnt++;
			}
			cnt[m[afta]].push_back(befa); //afta�� ����� ������Ʈ�� �̸����� vector�� ����
			//cout << cnt[m[afta]][j] << " ";
		}
	}

	string alp;
	cin >> alp;                                                                                                                                                       
	
	cout << score(cnt,m,alp) << endl;


	return 0;
}

int score(vector<string> cnt[], map<string,int> &m, string alpha)
{
	int total = 1;
	int size = cnt[m[alpha]].size();


		if (size !=0)
		{
			for (int j = 0; j < size; j++)
			{
				total += score(cnt,m,cnt[m[alpha]][j]);
			}
		}
	return total;
}