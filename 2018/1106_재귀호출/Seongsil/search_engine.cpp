/*백준 검색엔진

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
	map<string, int> m = { { "A", 0 }, { "B", 1 }, { "C", 2 }, { "D", 3 },
	{ "E", 4 }, { "F", 5 }, { "G", 6 }, { "H", 7 }, { "I", 8 }, { "J", 9 }, 
	{ "K", 10 }, { "L", 11 }, { "M", 12 }, { "N", 13 }, { "O", 14 }, { "P", 15 }, 
	{ "Q", 16 }, { "R", 17 }, { "S", 18 }, { "T", 19 }, { "U", 20 }, { "V", 21 }, 
	{ "W", 22 }, { "X", 23 }, { "Y", 24 }, { "Z", 25 }}; // key: A, value:0 | key:B, value:1 ...
	int n;

	vector<string> cnt[51];

	cin >> cases;
	for (int i = 0; i < cases; i++)
	{
		cin >> afta;
		cin >> n;

		for (int j = 0; j < n; j++)
		{
			string befa;
			cin >> befa;
			cnt[m[afta]].push_back(befa);
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