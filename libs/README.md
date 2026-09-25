# 编译依赖放这里（jar 不入版本控制）

1.21.1 分支要的 EMI：

```
emi-1.1.24+1.21.1+neoforge.jar
https://cdn.modrinth.com/data/fRiHVvU7/versions/5sIPA1To/emi-1.1.24%2B1.21.1%2Bneoforge.jar
```

下载后丢进这个目录就行。构建只取文件名里带 `1.21.1` 的那个 jar，所以版本号别从文件名里去掉。

AE2 从 Maven Central 拉（`org.appliedenergistics:appliedenergistics2`），不用放。EMI 之所以要本地 jar：它只发在 Emi 自己的 maven 上，国内连不上，Central 也没有。
