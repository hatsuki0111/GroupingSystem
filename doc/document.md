## 活動日程
[予定はこちらから](https://calendar.google.com/calendar/b/0?cid=Y2lzdC5iMjE3LnkueWFtYWRhQGdtYWlsLmNvbQ)  




# グループ分けシステム
## システムの概要
- グループに分ける際に、システムで簡易的に分けられるようにするシステムである。  
- このシステムにおいてグループに分ける人を「親」、グループに分けられる人を「子」とする。


## ヒアリングの内容
- 授業でグループを分ける際、紙でやっている
- 欠席者がいるとスムーズにグループを分けることができない
- ランダムでグループを分けることができると良い
- 学生が意見を出して、その意見を用いてグループ分けができると良い
- グループに分けた後、成果物などを管理できると良い


## 機能
- アカウントのCRUD  
- グループを分けるためのフォームの作成  
- 対象者を各グループに分ける  
- 分けられたグループの結果を随時閲覧する  
- 各グループで作成した資料等を掲示し、全員もしくは教員のみに閲覧させる  


## ユースケース図
### アクター
- 親
- 子

### 図
![任意でのグループ分け機能]()    


## ワークフロー図
### ログイン機能
![ログイン機能](aaaa)

### グループを分ける機能
![グループ分け機能](aaaa)

### 各グループの支援機能（未定）
![支援機能](aaaaa)


## シーケンス図
### 項目１
![](aaa)  

### 項目２
![](aaa)  

### 項目３
![](aaa)  

### 項目４
![](aaa)  


## データベースの設計
### データベースの構造
**accountテーブル**  

|カラム名|型|制約|  
|---|---|---|
|name|varchar(32)|PK|
|password|varchar(32)|NON|

**enqueteテーブル**

|カラム名|型|制約|
|---|---|---|
|id|bigint|PK|
|title|varchar(128)|NON|
|`author_account_name`|varchar(32)|NON,FK|
|`start_date_time`|timestamp|NON|
|`end_date_time`|timestamp|NON|


**optionテーブル**

|カラム名|型|制約|
|---|---|---|
|enquete_id|bigint|NON,FK|
|label|varchar(64)|NON|
|authorized|bool|NON|

**respondentテーブル**

|カラム名|型|制約|
|---|---|---|
|enquete_id|bigint|NON,FK|
|account_id|varchar(32)|NON,FK|

**selectedテーブル**

|カラム名|型|制約|
|---|---|---|
|account_name|varchar(32)|NON,FK|
|enquete_id|bigint|NON,FK|
|option_label|varchar(64)|NON|

### E-R図
![aaa](aaa)


## 活動日程 
[予定はこちらから](https://calendar.google.com/calendar/b/0?cid=Y2lzdC5iMjE3LnkueWFtYWRhQGdtYWlsLmNvbQ)
