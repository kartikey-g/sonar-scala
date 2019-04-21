/*
 * Copyright (C) 2018-2019  All sonar-scala contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mwz.sonar.scala
package pr

import com.mwz.sonar.scala.pr.Codec._
import io.circe.generic.extras.ConfiguredJsonCodec

final case class PullRequest(number: Int, head: Head)
final case class Head(sha: String)
final case class Comment(
  id: Int,
  path: String,
  position: Int, // Line in the diff.
  user: User,
  body: String
)
@ConfiguredJsonCodec
final case class NewComment(
  body: String,
  commitId: String,
  path: String,
  position: Int
)
final case class User(login: String)
final case class File(
  filename: String,
  status: String,
  patch: String
)
@ConfiguredJsonCodec
final case class Status(
  state: String,
  targetUrl: String,
  description: String,
  context: String
)
@ConfiguredJsonCodec
final case class NewStatus(
  state: String,
  targetUrl: String,
  description: String,
  context: String
)