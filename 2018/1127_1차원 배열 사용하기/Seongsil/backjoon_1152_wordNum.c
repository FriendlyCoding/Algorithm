/*baekjoon- 1152. �ܾ��� ����
Seongsil Heo */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	char sentence[1000000];

	//scanf("%[^\n]s",&sentence);
	gets(sentence);
	int count = 0;

	char *word = strtok(sentence, " ");
	
	//���ڿ��� �ּҰ��� ������ �ű⼭���� �и��� �õ��ϰ�, NULL�� ������ ������ �ڱⰡ ����� �����κ��� �и� �õ�
	while (word != NULL) 
	{
		if (word != ' ') //�Ǿ� �Ǵ� �ǵڿ� ������ �ִ� ��� ����
		{
			count++;
		}

		word = strtok(NULL, " ");
	}
	printf("%d", count);

	return 0;
}