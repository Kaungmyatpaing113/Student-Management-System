# Student-Management-System
# 🎓 学生管理システム (Student Management System)

## 📌 プロジェクトの目的 (Motivation)
将来、企業の業務を支える**「ビジネスシステム」を構築できるエンジニア**になりたいという強い目標があります。

## 📸 画面イメージ (Screenshots)
| ログイン画面 | メインメニュー |
| :---: | :---: |
| ![Login](https://github.com/user-attachments/assets/7edb22c9-c452-45e2-990f-cba7b8309cf3) | ![Menu](https://github.com/user-attachments/assets/446cae76-f6ef-4130-a8fb-fc930df71e0c) |

| 学生一覧 | 学生登録・編集 |
| :---: | :---: |
| ![List](https://github.com/user-attachments/assets/b8e34ff8-4cb0-406b-9e05-98501aa4442b) | ![Edit](https://github.com/user-attachments/assets/67f43f60-1c7f-4fc8-8084-4afc73c7f392) |

## 🛠️ 使用技術 (Tech Stack)
* **バックエンド:** Java (Servlet / JSP)
* **フロントエンド:** HTML, CSS
* **データベース:** MySQL (XAMPP)
* **サーバー:** Apache Tomcat 10
* **開発環境:** Eclipse

## ✨ アピールポイント (Key Features & Highlights)
1. **完全な MVC アーキテクチャ:**
   * `View` (JSP), `Controller` (Servlet), `Model` (Bean / DAO) を明確に分離し、保守性の高いコードを実現しました。
2. **コネクションプーリング (JNDI) の導入:**
   * データベース接続の負荷を軽減するため、`context.xml` にてコネクションプーリングを設定し、効率的なデータアクセス (DAOパターン) を実装しました。
3. **文字化け防止フィルター (Filter):**
   * 日本語環境での文字化け（エンコーディング問題）を防ぐため、`@WebFilter` を使用した `EncodingFilter.java` を実装し、すべてのリクエストをUTF-8で処理しています。
4. **セッション管理によるセキュリティ:**
   * ログイン状態を `HttpSession` で管理し、未ログイン状態で直接URLにアクセスされた場合は強制的にログイン画面へリダイレクトさせます。
5. **3つのメインエンティティのCRUD処理:**
   * 学生 (Student)、教師 (Teacher)、コース (Course) のすべてにおいて、「一覧表示・追加・更新・削除・検索」の機能が備わっています。

## ⚙️ 環境構築手順 (Setup Instructions)

このプロジェクトをローカル環境で動かすための手順です。

1. **データベースの準備 (MySQL)**
   * XAMPPを起動し、MySQLをスタートします。
   * phpMyAdmin等で `studentdb` という名前のデータベースを作成します。
   * `database/setup.sql` を実行し、テーブルと初期データを構築します。

2. **プロジェクトのインポート**
   * Eclipseに本プロジェクト (`StudentMnApp`) をインポートします。

3. **ライブラリの設定 (JDBC Driver)**
   * `mysql-connector-j-x.x.x.jar` をダウンロードし、`src/main/webapp/WEB-INF/lib/` フォルダ内に配置します。

4. **サーバーの起動**
   * Apache Tomcatサーバーにプロジェクトを追加し、起動します。
   * ブラウザから `http://localhost:8080/StudentMnApp/view/login.jsp` にアクセスします。

## 👤 ログイン情報 (Test Account)
テスト用のログインアカウントです。
* **ユーザーID:** `1`
* **教師名:** `大原 太郎`

---
*Created by [カウンミャットパイター/GitHubユーザー名➞Kaungmyatpaing113]*
