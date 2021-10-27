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

`Thing` 是所有类的基类, `Creature` 是可以移动的生物类, 玩家操控的是 `Player` 类, 这是 `Creature` 的子类.

`Tile` 相当于一个“容器”, 所有物体都被”放置”在一个 `Tile` 对象当中, 物体的移动只是将它从一个 `Tile` 移动到了另一个 `Tile` 当中, `tiles` 数组本身不变.

## 游戏逻辑

使用 <kbd>W</kbd> 、<kbd>A</kbd> 、<kbd>S</kbd>、 <kbd>D</kbd> 控制人物上下左右移动.

## 运行结果

[![走迷宫](maze-191220119.mov)](maze-191220119.mov)

