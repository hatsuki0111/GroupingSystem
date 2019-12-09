# 開発における注意事項

## Githubでの管理
1. 自分のbranch以外は絶対触らないこと。  
2. 自分のソースコードは次の流れで更新すること。  

```git
ブランチ作成
git branch branch名
ブランチ削除
git branch -D branch名
```

### ソース更新
```git
git add .
git commit -av
(git commit -m "コミット文")
git push origin branch名
※自分のbranch以外にpushしないこと
```

```
ブランチを作成する
git branch [new_branch_name]
ブランチを削除する
git branch -D [branch_name]
リモートのブランチを含めたすべてのブランチを閲覧する
git branch -a
ブランチを移動する
git checkout [branch_name]
リモートのブランチをすべてローカルにダウンロードする
git fetch
（ダウンロードするだけでマージはされません）
リモートのブランチを指定してローカルにダウンロードする
git fetch origin [local_branch]:[remote_branch_name]
（ダウンロードするだけでマージはされません）
現在checkoutしているブランチにマージする
git merge [branch_name]
（例えば、masterにいる状態で上記コマンドを実行するとmasterに上書きされます。注意！）
ローカルの特定のブランチをリモートの特定のブランチにpushする
git push origin [local_branch_name]:[remote_branch_name]
（これが多分一番安全だと思います。）
```