# W04-maze

191220119 王毓琦

## 文件结构

```
.
├── ApplicationMain.java
├── README.md
├── asciiPanel
├── maze		// 迷宫生成算法
├── resources
├── screen		// 屏幕绘制逻辑
└── world		// 游戏主要逻辑
```

## 类设计

UML 类型图如下:



`Thing` 是所有类的基类, `Creature` 是可以移动的生物类, 玩家操控的是 `Player` 类, 这是 `Creature` 的子类.

`Tile` 相当于一个“容器”, 所有物体都被”放置”在一个 `Tile` 对象当中, 物体的移动只是将它从一个 `Tile` 移动到了另一个 `Tile` 当中, `tiles` 数组本身不变.

## 游戏逻辑

使用 <kbd>W</kbd> 、<kbd>A</kbd> 、<kbd>S</kbd>、 <kbd>D</kbd> 控制人物上下左右移动.

加入了 BFS 算法寻找路径, 如果不知道路径可以按 <kbd>Enter</kbd> 获取提示. 

按下 <kbd>Enter</kbd> 后, 算法将从当前位置使用寻找到终点的路径, 并用黄色标记出应该走的路线.

## 运行结果

