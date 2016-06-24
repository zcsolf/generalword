package com.zcsolf.music;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * 
 * @author zcsolf 音频文件的播放
 */
public class BackgroundMusic {

	private static final String Tag = "Bg_music"; // Debug时追踪log的标识
	private Context context; // 上下文
	private float leftVolume; // 左音量，减音量
	private float rightVolume; // 右音量，加音量
	private MediaPlayer backgroundMediaPlayer; // 声明一个多媒体播放对象
	private boolean IsPaused; // 是否暂停的标识
	private String Path;

	public BackgroundMusic(Context context) {
		this.context = context;
		initData();
	}

	// 初始化数据
	private void initData() {
		leftVolume = 0.5f;
		rightVolume = 0.5f;
		backgroundMediaPlayer = null;
		IsPaused = false;
		Path = null;
	}

	/**
	 * 根据path路径播放背景音乐
	 * 
	 * @param path
	 *            :assets中的音频路径
	 * @param isLoop
	 *            :是否循环播放
	 */
	public void playBackgroundMusic(String path, boolean isLoop) {
		if (Path == null) {
			// 这是第一次播放音乐

			// 或者是执行end()方法后，重新被叫
			backgroundMediaPlayer = createMediaPlayerFromAssets(path);
			Path = path;
		} else {
			if (!Path.equals(path)) {
				// 播放一个新的背景音乐
				// 释放就的资源并生成一个新的

				if (backgroundMediaPlayer != null) {
					backgroundMediaPlayer.release(); // 释放对象的方法，可以减少移动设备的电量消耗

				}
				backgroundMediaPlayer = createMediaPlayerFromAssets(path);

				// 记录下这个路径
				Path = path;
			}
		}
		if (backgroundMediaPlayer == null) {
			Log.e(Tag, "playBackgroundMusic: background media player is null");
		} else {
			// 如果音乐正在播放或已经中断,停止运行

			backgroundMediaPlayer.stop();
			backgroundMediaPlayer.setLooping(isLoop);
			try {
				backgroundMediaPlayer.prepare();
				backgroundMediaPlayer.seekTo(0); // 寻找指定的时间位置
				backgroundMediaPlayer.start();
				this.IsPaused = false;
			} catch (Exception e) {
				Log.e(Tag, "playBackgroundMusic: error state");
			}
		}
	}

	/**
	 * create mediaplayer for music
	 * 
	 * @param path
	 *            the path relative to assets
	 * @return
	 */
	public MediaPlayer createMediaPlayerFromAssets(String path) {
		MediaPlayer mediaPlayer = null;
		try {
			AssetFileDescriptor assetFileDescriptor = context.getAssets()
					.openFd(path);
			mediaPlayer = new MediaPlayer();
			mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
					assetFileDescriptor.getStartOffset(),
					assetFileDescriptor.getLength());
			mediaPlayer.prepare();
	//		mediaPlayer.start();
			mediaPlayer.setVolume(leftVolume, rightVolume);
		} catch (Exception e) {
			mediaPlayer = null;
			Log.e(Tag, "error：" + e.getMessage(), e);
		}
		return mediaPlayer;
	}

	/**
	 * 停止播放背景音乐
	 */
	public void stopBackgroundMusic() {
		if (backgroundMediaPlayer != null) {
			backgroundMediaPlayer.stop();
			// 应该要设置这个状态，否则，紧跟的序列将会报错

			// play -> pause -> stop -> resume
			this.IsPaused = false;
		}
	}

	/**
	 * 暂停播放背景音乐
	 */
	public void pauseBackgroundMusic() {
		if (backgroundMediaPlayer != null && backgroundMediaPlayer.isPlaying()) {
			backgroundMediaPlayer.pause();
			this.IsPaused = true;
		}
	}

	/**
	 * 继续播放背景音乐
	 */
	public void resumeBackgroundMusic() {
		if (backgroundMediaPlayer != null && this.IsPaused) {
			backgroundMediaPlayer.start();
			this.IsPaused = false;
		}
	}

	/**
	 * 重新播放背景音乐
	 */
	public void reBackgroundMusic() {
		if (backgroundMediaPlayer != null) {
			backgroundMediaPlayer.stop();
			try {
				backgroundMediaPlayer.prepare();
				backgroundMediaPlayer.seekTo(0);
				backgroundMediaPlayer.start();
				this.IsPaused = false;
			} catch (Exception e) {
				Log.e(Tag, "reBackgroundMusic: error state");
			}
		}
	}

	/**
	 * 判断背景音乐是否正在播放
	 * 
	 * @return:返回的boolean值代表是否正在播放
	 */
	public boolean isBackgroundMusicPlaying() {
		boolean ret = false;
		if (backgroundMediaPlayer == null) {
			ret = false;
		} else {
			ret = backgroundMediaPlayer.isPlaying();
		}
		return ret;
	}

	/**
	 * 结束背景音乐,并释放资源
	 */
	public void End() {
		if (backgroundMediaPlayer != null) {
			backgroundMediaPlayer.release();
		}
		// 重新初始化
		initData();
	}

	/**
	 * 得到背景音乐的音量
	 * 
	 * @return
	 */
	public float getBackgroundVolume() {
		if (this.backgroundMediaPlayer != null) {
			return (this.leftVolume + this.rightVolume) / 2;
		} else {
			return 0.0f;
		}
	}

	/**
	 * 设置背景音乐的音量
	 * 
	 * @param volume
	 *            :设置播放的音量，float类型
	 */
	public void SetBackgroundMusicVolume(float volume) {
		this.leftVolume = this.rightVolume = volume;
		if (this.backgroundMediaPlayer != null) {
			this.backgroundMediaPlayer.setVolume(this.leftVolume,
					this.rightVolume);
		}
	}
}
