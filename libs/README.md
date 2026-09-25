# 编译依赖放这里（jar 不入版本控制）

1.20.1 分支要的 EMI：

```
emi-1.1.24+1.20.1+forge.jar
https://cdn.modrinth.com/data/fRiHVvU7/versions/Axuu9I9R/emi-1.1.24%2B1.20.1%2Bforge.jar
```

下载后丢进这个目录就行。构建只取文件名里带 `1.20.1` 的那个 jar，所以版本号别从文件名里去掉。

AE2 从 ModMaven 拉（`appeng:appliedenergistics2-forge`），不用放。EMI 之所以要本地 jar：它只发在 Emi 自己的 maven 上，国内连不上，Central 也没有。
