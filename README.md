# java8
shengsiyuan


git init
git status
git log
git add .
git commit -m "注释说明"
git push
git push --set-upstream origin master

git remote add origin git@github.com:RoBINBackha/java8.git
git pull --rebase origin master 拉去到本地
git push -u origin master 上传到github

git show ad1079c2c76aec675f74f2e1709231bcd2da3c08 
git reset ad1079c2c76aec675f74f2e1709231bcd2da3c08
checkout --<file>
rm --cached


git config --global user.name cjh
git config --global user.email 635102619@qq.com


git branch cjhbranch01 创建分支
git checkout cjhbranch01
git status

git checkout -b branch02 检出并创建新的分支

发布
先回到主分支
git checkout master
拉去内容
git pull
git merge cjhbranch01 
git merge origin/branch02 当本地没有这个分支时候要去远程拉

分支名称
工作区     Index     master


				objects

				远端
				
$ git status
On branch master
nothing to commit, working tree clean
