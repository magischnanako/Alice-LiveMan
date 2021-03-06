/*
 * <Alice LiveMan>
 * Copyright (C) <2018>  <NekoSunflower>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package site.alice.liveman.model;

import com.alibaba.fastjson.annotation.JSONField;
import site.alice.liveman.mediaproxy.proxytask.MediaProxyTask;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChannelInfo implements Serializable, Comparable<ChannelInfo> {
    private String               defaultAccountId;
    private boolean              autoBalance;
    private String               dynamicPostAccountId;
    private String               channelUrl;
    private String               channelName;
    private int[]                defaultArea;
    @JSONField(serialize = false)
    private String               mediaUrl;
    @JSONField(serialize = false)
    private List<MediaProxyTask> mediaProxyTasks;

    public ChannelInfo() {
    }

    public ChannelInfo(String channelName, String channelUrl) {
        this.channelName = channelName;
        this.channelUrl = channelUrl;
    }

    public String getDefaultAccountId() {
        return defaultAccountId;
    }

    public void setDefaultAccountId(String defaultAccountId) {
        this.defaultAccountId = defaultAccountId;
    }

    public boolean isAutoBalance() {
        return autoBalance;
    }

    public void setAutoBalance(boolean autoBalance) {
        this.autoBalance = autoBalance;
    }

    public String getDynamicPostAccountId() {
        return dynamicPostAccountId;
    }

    public void setDynamicPostAccountId(String dynamicPostAccountId) {
        this.dynamicPostAccountId = dynamicPostAccountId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public List<MediaProxyTask> getMediaProxyTasks() {
        return mediaProxyTasks;
    }

    public void setMediaProxyTasks(List<MediaProxyTask> mediaProxyTasks) {
        this.mediaProxyTasks = mediaProxyTasks;
    }

    public int[] getDefaultArea() {
        return defaultArea;
    }

    public void setDefaultArea(int[] defaultArea) {
        this.defaultArea = defaultArea;
    }

    public void addProxyTask(MediaProxyTask mediaProxyTask) {
        if (mediaProxyTasks == null) {
            mediaProxyTasks = new CopyOnWriteArrayList<>();
        }
        mediaProxyTask.setParentProxyTasks(mediaProxyTasks);
        mediaProxyTasks.add(mediaProxyTask);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelInfo that = (ChannelInfo) o;
        return Objects.equals(channelUrl, that.channelUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelUrl);
    }

    @Override
    public int compareTo( ChannelInfo o) {
        return this.getChannelName().compareTo(o.getChannelName());
    }
}
